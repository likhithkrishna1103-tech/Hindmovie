package da;

import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends n.k {
    @Override // n.k, android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, CharSequence charSequence) {
        n.m mVarA = a(i, i10, i11, charSequence);
        u uVar = new u(this.f8519a, this, mVarA);
        mVarA.f8556o = uVar;
        uVar.setHeaderTitle(mVarA.f8548e);
        return uVar;
    }
}
