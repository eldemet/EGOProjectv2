package egoproject;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class SplashWindow extends JWindow {
    private static final int FADE_DURATION_MS = 500;
    private static final int HOLD_DURATION_MS = 4000;
    private static final int TIMER_INTERVAL_MS = 25;
    private static Sequencer sharedSequencer;
    private final String midiPath;
    private final Runnable onComplete;
    private final SplashImagePanel panel;

    public SplashWindow(String imagePath, String midiPath, Runnable onComplete) {
        this.midiPath = midiPath;
        this.onComplete = onComplete;
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getIconWidth() <= 0 || icon.getIconHeight() <= 0) {
            throw new IllegalArgumentException("Could not load splash image: " + imagePath);
        }
        this.panel = new SplashImagePanel(icon);
        this.setBackground(new Color(0, 0, 0, 0));
        this.getContentPane().add(this.panel);
        this.pack();
        this.centerOnScreen();
    }

    private void centerOnScreen() {
        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int x = bounds.x + (bounds.width - this.getWidth()) / 2;
        int y = bounds.y + (bounds.height - this.getHeight()) / 2;
        this.setLocation(Math.max(bounds.x, x), Math.max(bounds.y, y));
    }

    public void showSplash() {
        this.panel.setAlpha(0.0f);
        this.setVisible(true);
        this.playMidiOnce();
        this.startFade(true, new Runnable() {

            public void run() {
                Timer holdTimer = new Timer(HOLD_DURATION_MS, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        SplashWindow.this.startFade(false, new Runnable() {

                            public void run() {
                                SplashWindow.this.dispose();
                                if (SplashWindow.this.onComplete != null) {
                                    SplashWindow.this.onComplete.run();
                                }
                            }
                        });
                    }
                });
                holdTimer.setRepeats(false);
                holdTimer.start();
            }
        });
    }

    private void startFade(final boolean fadeIn, final Runnable onFadeComplete) {
        final int totalSteps = Math.max(1, FADE_DURATION_MS / TIMER_INTERVAL_MS);
        final int[] step = new int[] { 0 };
        Timer fadeTimer = new Timer(TIMER_INTERVAL_MS, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ++step[0];
                float progress = (float) step[0] / (float) totalSteps;
                SplashWindow.this.panel.setAlpha(fadeIn ? progress : 1.0f - progress);
                if (step[0] >= totalSteps) {
                    ((Timer) e.getSource()).stop();
                    SplashWindow.this.panel.setAlpha(fadeIn ? 1.0f : 0.0f);
                    if (onFadeComplete != null) {
                        onFadeComplete.run();
                    }
                }
            }
        });
        fadeTimer.start();
    }

    private void playMidiOnce() {
        if (this.midiPath == null || this.midiPath.equals("")) {
            return;
        }
        try {
            SplashWindow.stopMidi();
            Sequence sequence = MidiSystem.getSequence(new java.io.File(this.midiPath));
            sharedSequencer = MidiSystem.getSequencer();
            if (sharedSequencer == null) {
                return;
            }
            sharedSequencer.open();
            sharedSequencer.addMetaEventListener(new MetaEventListener() {

                public void meta(javax.sound.midi.MetaMessage meta) {
                    if (meta.getType() == 47) {
                        SplashWindow.this.stopMidi();
                    }
                }
            });
            sharedSequencer.setSequence(sequence);
            sharedSequencer.setLoopCount(0);
            sharedSequencer.start();
        } catch (Exception e) {
            SplashWindow.stopMidi();
        }
    }

    private static void stopMidi() {
        if (sharedSequencer != null) {
            if (sharedSequencer.isRunning()) {
                sharedSequencer.stop();
            }
            if (sharedSequencer.isOpen()) {
                sharedSequencer.close();
            }
            sharedSequencer = null;
        }
    }

    private static class SplashImagePanel extends JComponent {
        private float alpha = 1.0f;
        private final Image image;
        private final int imageHeight;
        private final int imageWidth;

        private SplashImagePanel(ImageIcon icon) {
            this.image = icon.getImage();
            this.imageWidth = icon.getIconWidth();
            this.imageHeight = icon.getIconHeight();
            this.setPreferredSize(this.scaleToFit(icon.getIconWidth(), icon.getIconHeight()));
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics = (Graphics2D) g.create();
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.alpha));
            graphics.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
            graphics.dispose();
        }

        private Dimension scaleToFit(int width, int height) {
            int maxWidth = 900;
            int maxHeight = 500;
            double scale = Math.min(1.0,
                    Math.min((double) maxWidth / (double) width, (double) maxHeight / (double) height));
            return new Dimension(Math.max(1, (int) (width * scale)), Math.max(1, (int) (height * scale)));
        }

        private void setAlpha(float alpha) {
            this.alpha = Math.max(0.0f, Math.min(1.0f, alpha));
            this.repaint();
        }
    }
}
