package ff;

import f9.c0;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4584a = new j();

    public static final bf.d a(bf.d dVar, c0 c0Var) {
        ge.i.e(dVar, "<this>");
        ge.i.e(c0Var, "module");
        if (!ge.i.a(dVar.c(), bf.e.f1912d)) {
            return dVar.f() ? a(dVar.j(0), c0Var) : dVar;
        }
        v.h(dVar);
        return dVar;
    }

    public static final byte b(char c9) {
        if (c9 < '~') {
            return c.f4578b[c9];
        }
        return (byte) 0;
    }

    public static final void c(m mVar, String str) {
        mVar.p(mVar.f4599w - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence d(CharSequence charSequence, int i) {
        ge.i.e(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i != -1) {
                int i10 = i - 30;
                int i11 = i + 30;
                String str = i10 <= 0 ? "" : ".....";
                String str2 = i11 >= charSequence.length() ? "" : ".....";
                StringBuilder sbB = y.e.b(str);
                if (i10 < 0) {
                    i10 = 0;
                }
                int length = charSequence.length();
                if (i11 > length) {
                    i11 = length;
                }
                sbB.append(charSequence.subSequence(i10, i11).toString());
                sbB.append(str2);
                return sbB.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void e(bf.d dVar, ef.b bVar) {
        ge.i.e(dVar, "<this>");
        ge.i.e(bVar, "json");
        if (ge.i.a(dVar.c(), bf.f.f1914d)) {
            bVar.f3893a.getClass();
        }
    }

    public static final o f(bf.d dVar, ef.b bVar) {
        ge.i.e(dVar, "desc");
        w8.e eVarC = dVar.c();
        if (eVarC instanceof bf.a) {
            return o.A;
        }
        if (ge.i.a(eVarC, bf.f.f1915e)) {
            return o.f4606y;
        }
        if (!ge.i.a(eVarC, bf.f.f)) {
            return o.f4605x;
        }
        bf.d dVarA = a(dVar.j(0), bVar.f3894b);
        w8.e eVarC2 = dVarA.c();
        if ((eVarC2 instanceof bf.c) || ge.i.a(eVarC2, bf.e.f1913e)) {
            return o.f4607z;
        }
        bVar.f3893a.getClass();
        throw new d("Value of type '" + dVarA.b() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + dVarA.c() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }
}
