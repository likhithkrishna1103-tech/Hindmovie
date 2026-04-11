package hf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u f6137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f6138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6139w;

    public p(u uVar) {
        be.h.e(uVar, "sink");
        this.f6137u = uVar;
        this.f6138v = new f();
    }

    @Override // hf.g
    public final g Y(String str) {
        be.h.e(str, "string");
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.o0(str);
        a();
        return this;
    }

    public final g a() {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f6138v;
        long j5 = fVar.f6113v;
        if (j5 == 0) {
            j5 = 0;
        } else {
            r rVar = fVar.f6112u;
            be.h.b(rVar);
            r rVar2 = rVar.f6148g;
            be.h.b(rVar2);
            int i = rVar2.f6145c;
            if (i < 8192 && rVar2.f6147e) {
                j5 -= (long) (i - rVar2.f6144b);
            }
        }
        if (j5 > 0) {
            this.f6137u.b0(j5, fVar);
        }
        return this;
    }

    @Override // hf.u
    public final void b0(long j5, f fVar) {
        be.h.e(fVar, "source");
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.b0(j5, fVar);
        a();
    }

    @Override // hf.u
    public final y c() {
        return this.f6137u.c();
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        u uVar = this.f6137u;
        if (this.f6139w) {
            return;
        }
        try {
            f fVar = this.f6138v;
            long j5 = fVar.f6113v;
            if (j5 > 0) {
                uVar.b0(j5, fVar);
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
        this.f6139w = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // hf.g, hf.u, java.io.Flushable
    public final void flush() {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f6138v;
        long j5 = fVar.f6113v;
        u uVar = this.f6137u;
        if (j5 > 0) {
            uVar.b0(j5, fVar);
        }
        uVar.flush();
    }

    @Override // hf.g
    public final g g(i iVar) {
        be.h.e(iVar, "byteString");
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.h0(iVar);
        a();
        return this;
    }

    @Override // hf.g
    public final g h(long j5) {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.k0(j5);
        a();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f6139w;
    }

    public final String toString() {
        return "buffer(" + this.f6137u + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        be.h.e(byteBuffer, "source");
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f6138v.write(byteBuffer);
        a();
        return iWrite;
    }

    @Override // hf.g
    public final g writeByte(int i) {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.j0(i);
        a();
        return this;
    }

    @Override // hf.g
    public final g writeInt(int i) {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.l0(i);
        a();
        return this;
    }

    @Override // hf.g
    public final g writeShort(int i) {
        if (this.f6139w) {
            throw new IllegalStateException("closed");
        }
        this.f6138v.m0(i);
        a();
        return this;
    }

    @Override // hf.g
    public final g write(byte[] bArr) {
        if (!this.f6139w) {
            this.f6138v.g0(bArr.length, bArr);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
