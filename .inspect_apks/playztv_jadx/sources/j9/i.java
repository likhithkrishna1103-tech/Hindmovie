package j9;

import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends m.k {
    @Override // m.k, android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, CharSequence charSequence) {
        m.m mVarA = a(i, i10, i11, charSequence);
        u uVar = new u(this.f8205a, this, mVarA);
        mVarA.f8242o = uVar;
        uVar.setHeaderTitle(mVarA.f8234e);
        return uVar;
    }
}
