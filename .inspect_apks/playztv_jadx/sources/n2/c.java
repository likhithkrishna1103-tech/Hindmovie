package n2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.q;
import p1.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f8659e;
    public final b[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f8661h;

    public c(int i, int i10, long j5, long j8, int i11, boolean z2, a aVar, b[] bVarArr) {
        this.f8655a = i;
        this.f8656b = i10;
        this.f8660g = j5;
        this.f8661h = j8;
        this.f8657c = i11;
        this.f8658d = z2;
        this.f8659e = aVar;
        this.f = bVarArr;
    }

    @Override // l2.a
    public final Object a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i = 0;
        while (i < arrayList.size()) {
            z0 z0Var = (z0) arrayList.get(i);
            b bVar2 = this.f[z0Var.f10124v];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.a((q[]) arrayList3.toArray(new q[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f8648j[z0Var.f10125w]);
            i++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.a((q[]) arrayList3.toArray(new q[0])));
        }
        return new c(this.f8655a, this.f8656b, this.f8660g, this.f8661h, this.f8657c, this.f8658d, this.f8659e, (b[]) arrayList2.toArray(new b[0]));
    }
}
