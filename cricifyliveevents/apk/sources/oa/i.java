package oa;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements p5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f9726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9728c;

    public i(TabLayout tabLayout) {
        this.f9726a = new WeakReference(tabLayout);
    }

    public final void a(int i, float f) {
        boolean z10;
        TabLayout tabLayout = (TabLayout) this.f9726a.get();
        if (tabLayout != null) {
            int i10 = this.f9728c;
            boolean z11 = true;
            if (i10 != 2 || this.f9727b == 1) {
                z10 = true;
            } else {
                z10 = true;
                z11 = false;
            }
            if (i10 == 2 && this.f9727b == 0) {
                z10 = false;
            }
            tabLayout.l(i, f, z11, z10, false);
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = (TabLayout) this.f9726a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i10 = this.f9728c;
        tabLayout.j(tabLayout.f(i), i10 == 0 || (i10 == 2 && this.f9727b == 0));
    }
}
