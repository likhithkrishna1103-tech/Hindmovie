package b2;

import android.view.View;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1762b;

    public /* synthetic */ m(int i, int i10) {
        this.f1761a = i;
        this.f1762b = i10;
    }

    public int a() {
        int i = this.f1762b;
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
        View view = x0Var.f10962a;
        this.f1761a = view.getLeft();
        this.f1762b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
