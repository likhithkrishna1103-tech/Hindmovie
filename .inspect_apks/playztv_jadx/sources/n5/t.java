package n5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements c, o5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8813b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o5.i f8815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o5.i f8816e;
    public final o5.i f;

    public t(t5.b bVar, s5.p pVar) {
        this.f8812a = pVar.f11863e;
        this.f8814c = pVar.f11859a;
        o5.e eVarD0 = pVar.f11860b.D0();
        this.f8815d = (o5.i) eVarD0;
        o5.e eVarD02 = pVar.f11861c.D0();
        this.f8816e = (o5.i) eVarD02;
        o5.e eVarD03 = pVar.f11862d.D0();
        this.f = (o5.i) eVarD03;
        bVar.d(eVarD0);
        bVar.d(eVarD02);
        bVar.d(eVarD03);
        eVarD0.a(this);
        eVarD02.a(this);
        eVarD03.a(this);
    }

    @Override // o5.a
    public final void b() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f8813b;
            if (i >= arrayList.size()) {
                return;
            }
            ((o5.a) arrayList.get(i)).b();
            i++;
        }
    }

    public final void d(o5.a aVar) {
        this.f8813b.add(aVar);
    }

    @Override // n5.c
    public final void c(List list, List list2) {
    }
}
