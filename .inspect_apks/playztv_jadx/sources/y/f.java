package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f14393d;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14395g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f14390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14391b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14392c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14394e = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14396h = 1;
    public g i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14397j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f14398k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f14399l = new ArrayList();

    public f(o oVar) {
        this.f14393d = oVar;
    }

    @Override // y.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f14399l;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (!((f) obj).f14397j) {
                return;
            }
        }
        this.f14392c = true;
        o oVar = this.f14390a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f14391b) {
            this.f14393d.a(this);
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
        if (fVar != null && i == 1 && fVar.f14397j) {
            g gVar = this.i;
            if (gVar != null) {
                if (!gVar.f14397j) {
                    return;
                } else {
                    this.f = this.f14396h * gVar.f14395g;
                }
            }
            d(fVar.f14395g + this.f);
        }
        o oVar2 = this.f14390a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(o oVar) {
        this.f14398k.add(oVar);
        if (this.f14397j) {
            oVar.a(oVar);
        }
    }

    public final void c() {
        this.f14399l.clear();
        this.f14398k.clear();
        this.f14397j = false;
        this.f14395g = 0;
        this.f14392c = false;
        this.f14391b = false;
    }

    public void d(int i) {
        if (this.f14397j) {
            return;
        }
        this.f14397j = true;
        this.f14395g = i;
        ArrayList arrayList = this.f14398k;
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14393d.f14413b.f14135h0);
        sb2.append(":");
        switch (this.f14394e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                str = "LEFT";
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                str = "RIGHT";
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "TOP";
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb2.append(str);
        sb2.append("(");
        sb2.append(this.f14397j ? Integer.valueOf(this.f14395g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f14399l.size());
        sb2.append(":d=");
        sb2.append(this.f14398k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
