package ka;

import android.util.StateSet;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Serializable f7294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Serializable f7295e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f7296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f7297h;
    public Object i;

    public c0(m mVar) {
        this.f7291a = 0;
        d();
        a(StateSet.WILD_CARD, mVar);
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iH0 = ne.h.h0(str, '&', i, 4);
            if (iH0 == -1) {
                iH0 = str.length();
            }
            int iH02 = ne.h.h0(str, '=', i, 4);
            if (iH02 == -1 || iH02 > iH0) {
                String strSubstring = str.substring(i, iH0);
                ge.i.d(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i, iH02);
                ge.i.d(strSubstring2, "substring(...)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iH02 + 1, iH0);
                ge.i.d(strSubstring3, "substring(...)");
                arrayList.add(strSubstring3);
            }
            i = iH0 + 1;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Serializable, java.lang.Object, ka.m[]] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int[][], java.io.Serializable, java.lang.Object] */
    public void a(int[] iArr, m mVar) {
        int i = this.f7292b;
        if (i == 0 || iArr.length == 0) {
            this.f7293c = mVar;
        }
        int[][] iArr2 = (int[][]) this.f7294d;
        if (i >= iArr2.length) {
            int i10 = i + 10;
            ?? r32 = new int[i10][];
            System.arraycopy(iArr2, 0, r32, 0, i);
            this.f7294d = r32;
            ?? r12 = new m[i10];
            System.arraycopy((m[]) this.f7295e, 0, r12, 0, i);
            this.f7295e = r12;
        }
        int[][] iArr3 = (int[][]) this.f7294d;
        int i11 = this.f7292b;
        iArr3[i11] = iArr;
        ((m[]) this.f7295e)[i11] = mVar;
        this.f7292b = i11 + 1;
    }

    public kf.q b() {
        ArrayList arrayList;
        String str = (String) this.f7293c;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strD = zf.a.d((String) this.f7294d, 0, 0, 7);
        String strD2 = zf.a.d((String) this.f7295e, 0, 0, 7);
        String str2 = (String) this.f;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iC = c();
        ArrayList arrayList2 = (ArrayList) this.f7296g;
        ArrayList arrayList3 = new ArrayList(sd.l.f0(arrayList2, 10));
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList3.add(zf.a.d((String) obj, 0, 0, 7));
        }
        ArrayList arrayList4 = (ArrayList) this.f7297h;
        if (arrayList4 != null) {
            ArrayList arrayList5 = new ArrayList(sd.l.f0(arrayList4, 10));
            int size2 = arrayList4.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList4.get(i10);
                i10++;
                String str3 = (String) obj2;
                arrayList5.add(str3 != null ? zf.a.d(str3, 0, 0, 3) : null);
            }
            arrayList = arrayList5;
        } else {
            arrayList = null;
        }
        String str4 = (String) this.i;
        return new kf.q(str, strD, strD2, str2, iC, arrayList, str4 != null ? zf.a.d(str4, 0, 0, 7) : null, toString());
    }

    public int c() {
        int i = this.f7292b;
        if (i != -1) {
            return i;
        }
        String str = (String) this.f7293c;
        ge.i.b(str);
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, ka.m[]] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int[][], java.io.Serializable] */
    public void d() {
        this.f7293c = new m();
        this.f7294d = new int[10][];
        this.f7295e = new m[10];
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(kf.q r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.c0.e(kf.q, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.c0.toString():java.lang.String");
    }

    public c0(int i) {
        this.f7291a = i;
        switch (i) {
            case 1:
                this.f7294d = "";
                this.f7295e = "";
                this.f7292b = -1;
                this.f7296g = new ArrayList(new sd.g(new String[]{""}, true));
                break;
        }
    }
}
