package ue;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13000a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13003d;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f13005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13006h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13001b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13002c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13004e = -1;

    public n() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final o a() {
        ArrayList arrayList;
        String str = this.f13000a;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strE = b.e(this.f13001b, 0, 0, 7);
        String strE2 = b.e(this.f13002c, 0, 0, 7);
        String str2 = this.f13003d;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iB = b();
        ArrayList arrayList2 = this.f;
        ArrayList arrayList3 = new ArrayList(od.k.U(arrayList2));
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList3.add(b.e((String) obj, 0, 0, 7));
        }
        ArrayList arrayList4 = this.f13005g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(od.k.U(arrayList4));
            int size2 = arrayList4.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList4.get(i10);
                i10++;
                String str3 = (String) obj2;
                arrayList.add(str3 != null ? b.e(str3, 0, 0, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.f13006h;
        return new o(str, strE, strE2, str2, iB, arrayList3, arrayList, str4 != null ? b.e(str4, 0, 0, 7) : null, toString());
    }

    public final int b() {
        int i = this.f13004e;
        if (i != -1) {
            return i;
        }
        String str = this.f13000a;
        be.h.b(str);
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(ue.o r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ue.n.c(ue.o, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ue.n.toString():java.lang.String");
    }
}
