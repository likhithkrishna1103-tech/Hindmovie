package q1;

import aa.j0;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f10538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10539b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f10540c = new ByteBuffer[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10541d;

    public d(j0 j0Var) {
        this.f10538a = j0Var;
        e eVar = e.f10542e;
        this.f10541d = false;
    }

    public final void a() {
        ArrayList arrayList = this.f10539b;
        arrayList.clear();
        this.f10541d = false;
        int i = 0;
        while (true) {
            j0 j0Var = this.f10538a;
            if (i >= j0Var.size()) {
                break;
            }
            g gVar = (g) j0Var.get(i);
            gVar.flush();
            if (gVar.a()) {
                arrayList.add(gVar);
            }
            i++;
        }
        this.f10540c = new ByteBuffer[arrayList.size()];
        for (int i10 = 0; i10 <= b(); i10++) {
            this.f10540c[i10] = ((g) arrayList.get(i10)).c();
        }
    }

    public final int b() {
        return this.f10540c.length - 1;
    }

    public final boolean c() {
        return this.f10541d && ((g) this.f10539b.get(b())).b() && !this.f10540c[b()].hasRemaining();
    }

    public final boolean d() {
        return !this.f10539b.isEmpty();
    }

    public final void e(ByteBuffer byteBuffer) {
        boolean z2;
        for (boolean z10 = true; z10; z10 = z2) {
            z2 = false;
            int i = 0;
            while (i <= b()) {
                if (!this.f10540c[i].hasRemaining()) {
                    ArrayList arrayList = this.f10539b;
                    g gVar = (g) arrayList.get(i);
                    if (!gVar.b()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.f10540c[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : g.f10547a;
                        long jRemaining = byteBuffer2.remaining();
                        gVar.e(byteBuffer2);
                        this.f10540c[i] = gVar.c();
                        z2 |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f10540c[i].hasRemaining();
                    } else if (!this.f10540c[i].hasRemaining() && i < b()) {
                        ((g) arrayList.get(i + 1)).d();
                    }
                }
                i++;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        j0 j0Var = ((d) obj).f10538a;
        j0 j0Var2 = this.f10538a;
        if (j0Var2.size() != j0Var.size()) {
            return false;
        }
        for (int i = 0; i < j0Var2.size(); i++) {
            if (j0Var2.get(i) != j0Var.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f10538a.hashCode();
    }
}
