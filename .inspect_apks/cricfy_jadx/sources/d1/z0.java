package d1;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vd.h f3324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f3325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final se.b f3326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3328e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xe.c f3329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rd.j f3330h;
    public final rd.j i;

    public z0(vd.h hVar, File file) {
        ge.i.e(hVar, "context");
        ge.i.e(file, "file");
        this.f3324a = hVar;
        this.f3325b = file;
        Object obj = c1.f3214b;
        this.f3326c = new se.b(new u(file, (vd.c) null, 2), vd.i.f13722v, -2, re.a.f11004v, 0);
        this.f3327d = ".lock";
        this.f3328e = ".version";
        this.f = "fcntl failed: EAGAIN";
        this.f3329g = xe.d.a();
        this.f3330h = new rd.j(new w0(this, 1));
        this.i = new rd.j(new w0(this, 0));
    }

    public static final void f(z0 z0Var, File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    @Override // d1.s0
    public final Object a(xd.c cVar) {
        rd.j jVar = this.i;
        if (jVar.a()) {
            return new Integer(g1.f3232b.nativeGetCounterValue(((g1) jVar.getValue()).f3233a));
        }
        return pe.x.s(this.f3324a, new v0(this, null, 0), cVar);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[Catch: all -> 0x00be, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00be, blocks: (B:42:0x00ba, B:56:0x00d7, B:57:0x00da), top: B:78:0x0022, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d7 A[Catch: all -> 0x00be, TRY_ENTER, TryCatch #7 {all -> 0x00be, blocks: (B:42:0x00ba, B:56:0x00d7, B:57:0x00da), top: B:78:0x0022, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v20, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    @Override // d1.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(fe.l r9, xd.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.z0.b(fe.l, xd.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00de A[Catch: all -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00e2, blocks: (B:60:0x00de, B:72:0x00f9, B:73:0x00fc), top: B:85:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9 A[Catch: all -> 0x00e2, TRY_ENTER, TryCatch #1 {all -> 0x00e2, blocks: (B:60:0x00de, B:72:0x00f9, B:73:0x00fc), top: B:85:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0108  */
    /* JADX WARN: Type inference failed for: r2v0, types: [fe.p] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [d1.y0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v1 */
    @Override // d1.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(fe.p r19, xd.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.z0.c(fe.p, xd.c):java.lang.Object");
    }

    @Override // d1.s0
    public final se.c d() {
        return this.f3326c;
    }

    @Override // d1.s0
    public final Object e(g0 g0Var) {
        rd.j jVar = this.i;
        if (jVar.a()) {
            return new Integer(g1.f3232b.nativeIncrementAndGetCounterValue(((g1) jVar.getValue()).f3233a));
        }
        return pe.x.s(this.f3324a, new v0(this, null, 1), g0Var);
    }
}
