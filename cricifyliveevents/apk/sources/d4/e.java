package d4;

import android.view.View;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3357b;

    public /* synthetic */ e(int i, int i10) {
        this.f3356a = i;
        this.f3357b = i10;
    }

    public int a() {
        int i = this.f3357b;
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public void b(x0 x0Var) {
        View view = x0Var.f13387a;
        this.f3356a = view.getLeft();
        this.f3357b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
