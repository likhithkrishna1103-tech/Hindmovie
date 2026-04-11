package ag;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f458x;

    public p(u uVar) {
        ge.i.e(uVar, "sink");
        this.f456v = uVar;
        this.f457w = new e();
    }

    public final f a() {
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f457w;
        long j4 = eVar.f429w;
        if (j4 == 0) {
            j4 = 0;
        } else {
            r rVar = eVar.f428v;
            ge.i.b(rVar);
            r rVar2 = rVar.f467g;
            ge.i.b(rVar2);
            int i = rVar2.f464c;
            if (i < 8192 && rVar2.f466e) {
                j4 -= (long) (i - rVar2.f463b);
            }
        }
        if (j4 > 0) {
            this.f456v.a0(j4, eVar);
        }
        return this;
    }

    @Override // ag.u
    public final void a0(long j4, e eVar) {
        ge.i.e(eVar, "source");
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.a0(j4, eVar);
        a();
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        u uVar = this.f456v;
        if (this.f458x) {
            return;
        }
        try {
            e eVar = this.f457w;
            long j4 = eVar.f429w;
            if (j4 > 0) {
                uVar.a0(j4, eVar);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            uVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f458x = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ag.u
    public final y d() {
        return this.f456v.d();
    }

    @Override // ag.f, ag.u, java.io.Flushable
    public final void flush() {
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f457w;
        long j4 = eVar.f429w;
        u uVar = this.f456v;
        if (j4 > 0) {
            uVar.a0(j4, eVar);
        }
        uVar.flush();
    }

    public final f g(String str) {
        ge.i.e(str, "string");
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.o0(str);
        a();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f458x;
    }

    public final String toString() {
        return "buffer(" + this.f456v + ')';
    }

    @Override // ag.f
    public final f u(h hVar) {
        ge.i.e(hVar, "byteString");
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.g0(hVar);
        a();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        ge.i.e(byteBuffer, "source");
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f457w.write(byteBuffer);
        a();
        return iWrite;
    }

    @Override // ag.f
    public final f writeByte(int i) {
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.i0(i);
        a();
        return this;
    }

    @Override // ag.f
    public final f writeInt(int i) {
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.l0(i);
        a();
        return this;
    }

    @Override // ag.f
    public final f writeShort(int i) {
        if (this.f458x) {
            throw new IllegalStateException("closed");
        }
        this.f457w.m0(i);
        a();
        return this;
    }

    @Override // ag.f
    public final f write(byte[] bArr) {
        if (!this.f458x) {
            this.f457w.e0(bArr.length, bArr);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
