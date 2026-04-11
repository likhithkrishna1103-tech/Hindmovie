package df;

import com.google.android.gms.internal.measurement.o4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3693a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3694b = new o("kotlin.Boolean", bf.b.f1908d);

    @Override // ze.a
    public final Object b(ff.k kVar) {
        boolean z10;
        boolean z11;
        ge.i.e(kVar, "decoder");
        ff.m mVar = (ff.m) kVar.f4589d;
        int iB = mVar.B();
        String str = (String) mVar.f4602z;
        if (iB == str.length()) {
            ff.m.q(mVar, "EOF", 0, 6);
            throw null;
        }
        if (str.charAt(iB) == '\"') {
            iB++;
            z10 = true;
        } else {
            z10 = false;
        }
        int iA = mVar.A(iB);
        if (iA >= str.length() || iA == -1) {
            ff.m.q(mVar, "EOF", 0, 6);
            throw null;
        }
        int i = iA + 1;
        int iCharAt = str.charAt(iA) | ' ';
        if (iCharAt == 102) {
            mVar.h(i, "alse");
            z11 = false;
        } else {
            if (iCharAt != 116) {
                ff.m.q(mVar, "Expected valid boolean literal prefix, but had '" + mVar.m() + '\'', 0, 6);
                throw null;
            }
            mVar.h(i, "rue");
            z11 = true;
        }
        if (z10) {
            if (mVar.f4599w == str.length()) {
                ff.m.q(mVar, "EOF", 0, 6);
                throw null;
            }
            if (str.charAt(mVar.f4599w) != '\"') {
                ff.m.q(mVar, "Expected closing quotation mark", 0, 6);
                throw null;
            }
            mVar.f4599w++;
        }
        return Boolean.valueOf(z11);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (lVar.f4592b) {
            lVar.j(String.valueOf(zBooleanValue));
        } else {
            ((ag.o) ((o4) lVar.f4593c).f2561w).o(String.valueOf(zBooleanValue));
        }
    }

    @Override // ze.a
    public final bf.d d() {
        return f3694b;
    }
}
