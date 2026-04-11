package q0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p1 {
    public static int a(int i) {
        int iStatusBars;
        int i10 = 0;
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((i & i11) != 0) {
                if (i11 == 1) {
                    iStatusBars = WindowInsets.Type.statusBars();
                } else if (i11 == 2) {
                    iStatusBars = WindowInsets.Type.navigationBars();
                } else if (i11 == 4) {
                    iStatusBars = WindowInsets.Type.captionBar();
                } else if (i11 == 8) {
                    iStatusBars = WindowInsets.Type.ime();
                } else if (i11 == 16) {
                    iStatusBars = WindowInsets.Type.systemGestures();
                } else if (i11 == 32) {
                    iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i11 == 64) {
                    iStatusBars = WindowInsets.Type.tappableElement();
                } else if (i11 == 128) {
                    iStatusBars = WindowInsets.Type.displayCutout();
                }
                i10 |= iStatusBars;
            }
        }
        return i10;
    }
}
