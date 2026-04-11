package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f1605d;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1607g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f1602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1603b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1604c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1606e = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1608h = 1;
    public g i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1609j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f1610k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f1611l = new ArrayList();

    public f(o oVar) {
        this.f1605d = oVar;
    }

    @Override // b0.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f1611l;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (!((f) obj).f1609j) {
                return;
            }
        }
        this.f1604c = true;
        o oVar = this.f1602a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f1603b) {
            this.f1605d.a(this);
            return;
        }
        int size2 = arrayList.size();
        f fVar = null;
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            f fVar2 = (f) obj2;
            if (!(fVar2 instanceof g)) {
                i++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i == 1 && fVar.f1609j) {
            g gVar = this.i;
            if (gVar != null) {
                if (!gVar.f1609j) {
                    return;
                } else {
                    this.f = this.f1608h * gVar.f1607g;
                }
            }
            d(fVar.f1607g + this.f);
        }
        o oVar2 = this.f1602a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(o oVar) {
        this.f1610k.add(oVar);
        if (this.f1609j) {
            oVar.a(oVar);
        }
    }

    public final void c() {
        this.f1611l.clear();
        this.f1610k.clear();
        this.f1609j = false;
        this.f1607g = 0;
        this.f1604c = false;
        this.f1603b = false;
    }

    public void d(int i) {
        if (this.f1609j) {
            return;
        }
        this.f1609j = true;
        this.f1607g = i;
        ArrayList arrayList = this.f1610k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1605d.f1625b.f40h0);
        sb.append(":");
        switch (this.f1606e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                str = "LEFT";
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                str = "RIGHT";
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "TOP";
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "BOTTOM";
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f1609j ? Integer.valueOf(this.f1607g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1611l.size());
        sb.append(":d=");
        sb.append(this.f1610k.size());
        sb.append(">");
        return sb.toString();
    }
}
