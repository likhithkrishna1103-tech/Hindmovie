package df;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf.d[] f3712a = new bf.d[0];

    public static final void a(int i, int i10, bf.d dVar) {
        ge.i.e(dVar, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i11 = (~i) & i10;
        for (int i12 = 0; i12 < 32; i12++) {
            if ((i11 & 1) != 0) {
                arrayList.add(dVar.e(i12));
            }
            i11 >>>= 1;
        }
        String strB = dVar.b();
        ge.i.e(strB, "serialName");
        throw new ze.b(arrayList, arrayList.size() == 1 ? "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + strB + "', but it was missing" : "Fields " + arrayList + " are required for type with serial name '" + strB + "', but they were missing", null);
    }
}
