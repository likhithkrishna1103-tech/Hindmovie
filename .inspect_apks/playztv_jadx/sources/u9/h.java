package u9;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements k5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f12808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12810c;

    public h(TabLayout tabLayout) {
        this.f12808a = new WeakReference(tabLayout);
    }

    public final void a(int i, float f) {
        boolean z2;
        TabLayout tabLayout = (TabLayout) this.f12808a.get();
        if (tabLayout != null) {
            int i10 = this.f12810c;
            boolean z10 = true;
            if (i10 != 2 || this.f12809b == 1) {
                z2 = true;
            } else {
                z2 = true;
                z10 = false;
            }
            if (i10 == 2 && this.f12809b == 0) {
                z2 = false;
            }
            tabLayout.l(i, f, z10, z2, false);
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = (TabLayout) this.f12808a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i10 = this.f12810c;
        tabLayout.j(tabLayout.f(i), i10 == 0 || (i10 == 2 && this.f12809b == 0));
    }
}
