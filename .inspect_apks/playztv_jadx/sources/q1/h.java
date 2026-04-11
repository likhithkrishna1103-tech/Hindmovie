package q1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f10548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f10549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f10550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f10551e;
    public ByteBuffer f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f10552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10553h;

    public h() {
        ByteBuffer byteBuffer = g.f10547a;
        this.f = byteBuffer;
        this.f10552g = byteBuffer;
        e eVar = e.f10542e;
        this.f10550d = eVar;
        this.f10551e = eVar;
        this.f10548b = eVar;
        this.f10549c = eVar;
    }

    @Override // q1.g
    public boolean a() {
        return this.f10551e != e.f10542e;
    }

    @Override // q1.g
    public boolean b() {
        return this.f10553h && this.f10552g == g.f10547a;
    }

    @Override // q1.g
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f10552g;
        this.f10552g = g.f10547a;
        return byteBuffer;
    }

    @Override // q1.g
    public final void d() {
        this.f10553h = true;
        i();
    }

    @Override // q1.g
    public final e f(e eVar) {
        this.f10550d = eVar;
        this.f10551e = g(eVar);
        return a() ? this.f10551e : e.f10542e;
    }

    @Override // q1.g
    public final void flush() {
        this.f10552g = g.f10547a;
        this.f10553h = false;
        this.f10548b = this.f10550d;
        this.f10549c = this.f10551e;
        h();
    }

    public abstract e g(e eVar);

    public final ByteBuffer k(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.f10552g = byteBuffer;
        return byteBuffer;
    }

    @Override // q1.g
    public final void reset() {
        ByteBuffer byteBuffer = g.f10547a;
        this.f10552g = byteBuffer;
        this.f10553h = false;
        this.f = byteBuffer;
        e eVar = e.f10542e;
        this.f10550d = eVar;
        this.f10551e = eVar;
        this.f10548b = eVar;
        this.f10549c = eVar;
        j();
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
