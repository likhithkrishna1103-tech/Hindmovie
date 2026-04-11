package f5;

import ge.i;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c5.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d5.b f3961v;

    public a(d5.b bVar) {
        i.e(bVar, "db");
        this.f3961v = bVar;
    }

    @Override // c5.a
    public final boolean c() {
        return this.f3961v.c();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3  */
    @Override // c5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c5.c c0(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.c0(java.lang.String):c5.c");
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f3961v.close();
    }
}
