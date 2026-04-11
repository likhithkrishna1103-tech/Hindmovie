package i6;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements d, j6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f6340b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j6.i f6342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j6.i f6343e;
    public final j6.i f;

    public u(o6.a aVar, n6.p pVar) {
        this.f6339a = pVar.f8847e;
        this.f6341c = pVar.f8843a;
        j6.i iVarD0 = pVar.f8844b.D0();
        this.f6342d = iVarD0;
        j6.i iVarD02 = pVar.f8845c.D0();
        this.f6343e = iVarD02;
        j6.i iVarD03 = pVar.f8846d.D0();
        this.f = iVarD03;
        aVar.d(iVarD0);
        aVar.d(iVarD02);
        aVar.d(iVarD03);
        iVarD0.a(this);
        iVarD02.a(this);
        iVarD03.a(this);
    }

    @Override // j6.a
    public final void b() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6340b;
            if (i >= arrayList.size()) {
                return;
            }
            ((j6.a) arrayList.get(i)).b();
            i++;
        }
    }

    public final void d(j6.a aVar) {
        this.f6340b.add(aVar);
    }

    @Override // i6.d
    public final void c(List list, List list2) {
    }
}
