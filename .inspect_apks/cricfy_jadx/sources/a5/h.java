package a5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f288e;

    public h(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2) {
        ge.i.e(str, "referenceTable");
        ge.i.e(str2, "onDelete");
        ge.i.e(str3, "onUpdate");
        this.f284a = str;
        this.f285b = str2;
        this.f286c = str3;
        this.f287d = arrayList;
        this.f288e = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (ge.i.a(this.f284a, hVar.f284a) && ge.i.a(this.f285b, hVar.f285b) && ge.i.a(this.f286c, hVar.f286c) && this.f287d.equals(hVar.f287d)) {
            return this.f288e.equals(hVar.f288e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f288e.hashCode() + ((this.f287d.hashCode() + l0.e.e(l0.e.e(this.f284a.hashCode() * 31, 31, this.f285b), 31, this.f286c)) * 31);
    }

    public final String toString() {
        return ne.i.T(ne.i.U("\n            |ForeignKey {\n            |   referenceTable = '" + this.f284a + "',\n            |   onDelete = '" + this.f285b + "',\n            |   onUpdate = '" + this.f286c + "',\n            |   columnNames = {" + com.bumptech.glide.f.C(sd.j.o0(this.f287d)) + "\n            |   referenceColumnNames = {" + com.bumptech.glide.f.B(sd.j.o0(this.f288e)) + "\n            |}\n        "));
    }
}
