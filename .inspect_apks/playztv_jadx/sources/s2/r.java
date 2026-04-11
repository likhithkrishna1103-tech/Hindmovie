package s2;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c4.d f11779g = new c4.d(17);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c4.d f11780h = new c4.d(18);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11785e;
    public int f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q[] f11782b = new q[5];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11781a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11783c = -1;

    public final void a(int i, float f) {
        q qVar;
        int i10 = this.f11783c;
        ArrayList arrayList = this.f11781a;
        if (i10 != 1) {
            Collections.sort(arrayList, f11779g);
            this.f11783c = 1;
        }
        int i11 = this.f;
        q[] qVarArr = this.f11782b;
        if (i11 > 0) {
            int i12 = i11 - 1;
            this.f = i12;
            qVar = qVarArr[i12];
        } else {
            qVar = new q();
        }
        int i13 = this.f11784d;
        this.f11784d = i13 + 1;
        qVar.f11776a = i13;
        qVar.f11777b = i;
        qVar.f11778c = f;
        arrayList.add(qVar);
        this.f11785e += i;
        while (true) {
            int i14 = this.f11785e;
            if (i14 <= 2000) {
                return;
            }
            int i15 = i14 - 2000;
            q qVar2 = (q) arrayList.get(0);
            int i16 = qVar2.f11777b;
            if (i16 <= i15) {
                this.f11785e -= i16;
                arrayList.remove(0);
                int i17 = this.f;
                if (i17 < 5) {
                    this.f = i17 + 1;
                    qVarArr[i17] = qVar2;
                }
            } else {
                qVar2.f11777b = i16 - i15;
                this.f11785e -= i15;
            }
        }
    }

    public final float b() {
        int i = this.f11783c;
        ArrayList arrayList = this.f11781a;
        if (i != 0) {
            Collections.sort(arrayList, f11780h);
            this.f11783c = 0;
        }
        float f = 0.5f * this.f11785e;
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            q qVar = (q) arrayList.get(i11);
            i10 += qVar.f11777b;
            if (i10 >= f) {
                return qVar.f11778c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((q) arrayList.get(arrayList.size() - 1)).f11778c;
    }
}
