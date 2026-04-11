package w1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f13796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f13797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f13798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f13799e;
    public ByteBuffer f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f13800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13801h;

    public i() {
        ByteBuffer byteBuffer = h.f13795a;
        this.f = byteBuffer;
        this.f13800g = byteBuffer;
        f fVar = f.f13790e;
        this.f13798d = fVar;
        this.f13799e = fVar;
        this.f13796b = fVar;
        this.f13797c = fVar;
    }

    @Override // w1.h
    public boolean a() {
        return this.f13799e != f.f13790e;
    }

    @Override // w1.h
    public boolean b() {
        return this.f13801h && this.f13800g == h.f13795a;
    }

    @Override // w1.h
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f13800g;
        this.f13800g = h.f13795a;
        return byteBuffer;
    }

    @Override // w1.h
    public final void d() {
        this.f13801h = true;
        i();
    }

    @Override // w1.h
    public final f e(f fVar) {
        this.f13798d = fVar;
        this.f13799e = g(fVar);
        return a() ? this.f13799e : f.f13790e;
    }

    @Override // w1.h
    public final void flush() {
        this.f13800g = h.f13795a;
        this.f13801h = false;
        this.f13796b = this.f13798d;
        this.f13797c = this.f13799e;
        h();
    }

    public abstract f g(f fVar);

    public final ByteBuffer k(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.f13800g = byteBuffer;
        return byteBuffer;
    }

    @Override // w1.h
    public final void reset() {
        ByteBuffer byteBuffer = h.f13795a;
        this.f13800g = byteBuffer;
        this.f13801h = false;
        this.f = byteBuffer;
        f fVar = f.f13790e;
        this.f13798d = fVar;
        this.f13799e = fVar;
        this.f13796b = fVar;
        this.f13797c = fVar;
        j();
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
