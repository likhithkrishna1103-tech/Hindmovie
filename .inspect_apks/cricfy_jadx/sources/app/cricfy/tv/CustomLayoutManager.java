package app.cricfy.tv;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import q5.c;
import s5.i;
import v4.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CustomLayoutManager extends GridLayoutManager {
    public CustomLayoutManager(i iVar) {
        super(3);
        this.K = new c(iVar);
    }

    @Override // v4.h0
    public final void Y(View view, int i) {
        try {
            int iG = h0.G(view);
            int iB = B();
            int i10 = this.F + iG;
            if (i != 130 || iG < 0 || i10 >= iB) {
                return;
            }
            r0(i10);
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }
}
