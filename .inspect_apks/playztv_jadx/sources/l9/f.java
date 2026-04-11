package l9;

import android.content.Context;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends m.k {
    public final int A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Class f8037z;

    public f(Context context, Class cls, int i) {
        super(context);
        this.f8037z = cls;
        this.A = i;
    }

    @Override // m.k
    public final m.m a(int i, int i10, int i11, CharSequence charSequence) {
        int size = this.f.size() + 1;
        int i12 = this.A;
        if (size <= i12) {
            y();
            m.m mVarA = super.a(i, i10, i11, charSequence);
            mVarA.f(true);
            x();
            return mVarA;
        }
        String simpleName = this.f8037z.getSimpleName();
        StringBuilder sb2 = new StringBuilder("Maximum number of items supported by ");
        sb2.append(simpleName);
        sb2.append(" is ");
        sb2.append(i12);
        sb2.append(". Limit can be checked with ");
        throw new IllegalArgumentException(l4.a.o(sb2, simpleName, "#getMaxItemCount()"));
    }

    @Override // m.k, android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f8037z.getSimpleName().concat(" does not support submenus"));
    }
}
