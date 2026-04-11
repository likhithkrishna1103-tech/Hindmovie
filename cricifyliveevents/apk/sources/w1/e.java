package w1;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import ua.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f13786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f13787b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f13788c = new ByteBuffer[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13789d;

    public e(i0 i0Var) {
        this.f13786a = i0Var;
        f fVar = f.f13790e;
        this.f13789d = false;
    }

    public final void a() {
        ArrayList arrayList = this.f13787b;
        arrayList.clear();
        this.f13789d = false;
        int i = 0;
        while (true) {
            i0 i0Var = this.f13786a;
            if (i >= i0Var.size()) {
                break;
            }
            h hVar = (h) i0Var.get(i);
            hVar.flush();
            if (hVar.a()) {
                arrayList.add(hVar);
            }
            i++;
        }
        this.f13788c = new ByteBuffer[arrayList.size()];
        for (int i10 = 0; i10 <= b(); i10++) {
            this.f13788c[i10] = ((h) arrayList.get(i10)).c();
        }
    }

    public final int b() {
        return this.f13788c.length - 1;
    }

    public final boolean c() {
        return this.f13789d && ((h) this.f13787b.get(b())).b() && !this.f13788c[b()].hasRemaining();
    }

    public final boolean d() {
        return !this.f13787b.isEmpty();
    }

    public final void e(ByteBuffer byteBuffer) {
        boolean z10;
        for (boolean z11 = true; z11; z11 = z10) {
            z10 = false;
            int i = 0;
            while (i <= b()) {
                if (!this.f13788c[i].hasRemaining()) {
                    ArrayList arrayList = this.f13787b;
                    h hVar = (h) arrayList.get(i);
                    if (!hVar.b()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.f13788c[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : h.f13795a;
                        long jRemaining = byteBuffer2.remaining();
                        hVar.f(byteBuffer2);
                        this.f13788c[i] = hVar.c();
                        z10 |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f13788c[i].hasRemaining();
                    } else if (!this.f13788c[i].hasRemaining() && i < b()) {
                        ((h) arrayList.get(i + 1)).d();
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
        if (!(obj instanceof e)) {
            return false;
        }
        i0 i0Var = ((e) obj).f13786a;
        i0 i0Var2 = this.f13786a;
        if (i0Var2.size() != i0Var.size()) {
            return false;
        }
        for (int i = 0; i < i0Var2.size(); i++) {
            if (i0Var2.get(i) != i0Var.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f13786a.hashCode();
    }
}
