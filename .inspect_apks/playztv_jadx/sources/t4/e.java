package t4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f12111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f12112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ThreadLocal f12113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f12114x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f12115y;

    public e(p2.c cVar) {
        this.f12113w = new ThreadLocal();
        this.f12114x = new AtomicBoolean(false);
        int i = je.a.f6958x;
        this.f12115y = a.a.N(30, je.c.SECONDS);
        h hVar = new h(1, new a5.e(6, cVar));
        this.f12111u = hVar;
        this.f12112v = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a5 A[Catch: all -> 0x01bd, TRY_LEAVE, TryCatch #8 {all -> 0x01bd, blocks: (B:89:0x019f, B:91:0x01a5, B:93:0x01af, B:94:0x01b4), top: B:136:0x019f }] */
    @Override // t4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(boolean r18, ae.p r19, td.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.e.I(boolean, ae.p, td.c):java.lang.Object");
    }

    public final void a(boolean z2) {
        String str = z2 ? "reader" : "writer";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Timed out attempting to acquire a " + str + " connection.");
        sb2.append("\n\nWriter pool:\n");
        this.f12112v.c(sb2);
        sb2.append("Reader pool:");
        sb2.append('\n');
        this.f12111u.c(sb2);
        android.support.v4.media.session.b.O(sb2.toString(), 5);
        throw null;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f12114x.compareAndSet(false, true)) {
            this.f12111u.b();
            this.f12112v.b();
        }
    }

    public e(final p2.c cVar, final String str, int i) {
        be.h.e(str, "fileName");
        this.f12113w = new ThreadLocal();
        final int i10 = 0;
        this.f12114x = new AtomicBoolean(false);
        int i11 = je.a.f6958x;
        this.f12115y = a.a.N(30, je.c.SECONDS);
        if (i > 0) {
            this.f12111u = new h(i, new ae.a() { // from class: t4.c
                @Override // ae.a
                public final Object b() throws Exception {
                    switch (i10) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            y4.a aVarA = cVar.a(str);
                            android.support.v4.media.session.b.o(aVarA, "PRAGMA query_only = 1");
                            return aVarA;
                        default:
                            return cVar.a(str);
                    }
                }
            });
            final int i12 = 1;
            this.f12112v = new h(1, new ae.a() { // from class: t4.c
                @Override // ae.a
                public final Object b() throws Exception {
                    switch (i12) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            y4.a aVarA = cVar.a(str);
                            android.support.v4.media.session.b.o(aVarA, "PRAGMA query_only = 1");
                            return aVarA;
                        default:
                            return cVar.a(str);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
    }
}
