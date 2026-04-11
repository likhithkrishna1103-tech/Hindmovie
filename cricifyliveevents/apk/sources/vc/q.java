package vc;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13677v;

    public static d1.h0 b(d1.f1 f1Var, e1.a aVar, ue.c cVar, fe.a aVar2) {
        sd.p pVar = sd.p.f11669v;
        vd.c cVar2 = null;
        try {
            System.loadLibrary("datastore_shared_counter");
            return new d1.h0(new d1.l0(f1Var, new d1.e0(1, cVar), aVar2), n5.a.x(new d1.e(pVar, cVar2, 0)), aVar, cVar);
        } catch (SecurityException | UnsatisfiedLinkError unused) {
            return new d1.h0(new d1.l0(f1Var, d1.k0.f3258w, aVar2), n5.a.x(new d1.e(pVar, cVar2, 0)), aVar, cVar);
        }
    }

    public static void c(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return;
        }
        if (parentFile.exists() && !parentFile.isDirectory() && ge.i.a(parentFile.getName(), "firebaseSessions") && !parentFile.delete()) {
            throw new IOException("Failed to delete conflicting file: " + parentFile);
        }
        if (parentFile.isDirectory()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Files.createDirectories(parentFile.toPath(), new FileAttribute[0]);
                return;
            } catch (Exception e9) {
                throw new IOException("Failed to create directory: " + parentFile, e9);
            }
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Failed to create directory: " + parentFile);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        if (r10 == r6) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [ic.d] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ic.d r9, xd.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof vc.v
            if (r0 == 0) goto L13
            r0 = r10
            vc.v r0 = (vc.v) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            vc.v r0 = new vc.v
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f13702z
            int r1 = r0.B
            java.lang.String r2 = "FirebaseSessions"
            r3 = 2
            r4 = 1
            java.lang.String r5 = ""
            wd.a r6 = wd.a.f14143v
            if (r1 == 0) goto L47
            if (r1 == r4) goto L3d
            if (r1 != r3) goto L35
            java.lang.Object r9 = r0.f13701y
            java.lang.String r9 = (java.lang.String) r9
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Exception -> L32
            goto L8d
        L32:
            r10 = move-exception
            goto L94
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r9 = r0.f13701y
            ic.d r9 = (ic.d) r9
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Exception -> L45
            goto L64
        L45:
            r10 = move-exception
            goto L70
        L47:
            com.bumptech.glide.c.C(r10)
            r10 = r9
            ic.c r10 = (ic.c) r10     // Catch: java.lang.Exception -> L45
            j9.p r9 = r10.e()     // Catch: java.lang.Exception -> L45
            java.lang.String r1 = "getToken(...)"
            ge.i.d(r9, r1)     // Catch: java.lang.Exception -> L6c
            r0.f13701y = r10     // Catch: java.lang.Exception -> L6c
            r0.B = r4     // Catch: java.lang.Exception -> L6c
            java.lang.Object r9 = w4.v.e(r9, r0)     // Catch: java.lang.Exception -> L6c
            if (r9 != r6) goto L61
            goto L8c
        L61:
            r7 = r10
            r10 = r9
            r9 = r7
        L64:
            ic.a r10 = (ic.a) r10     // Catch: java.lang.Exception -> L45
            java.lang.String r10 = r10.f6414a     // Catch: java.lang.Exception -> L45
            r7 = r10
            r10 = r9
            r9 = r7
            goto L77
        L6c:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L70:
            java.lang.String r1 = "Error getting authentication token."
            android.util.Log.w(r2, r1, r10)
            r10 = r9
            r9 = r5
        L77:
            ic.c r10 = (ic.c) r10     // Catch: java.lang.Exception -> L32
            j9.p r10 = r10.d()     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = "getId(...)"
            ge.i.d(r10, r1)     // Catch: java.lang.Exception -> L32
            r0.f13701y = r9     // Catch: java.lang.Exception -> L32
            r0.B = r3     // Catch: java.lang.Exception -> L32
            java.lang.Object r10 = w4.v.e(r10, r0)     // Catch: java.lang.Exception -> L32
            if (r10 != r6) goto L8d
        L8c:
            return r6
        L8d:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L32
            if (r10 != 0) goto L92
            goto L99
        L92:
            r5 = r10
            goto L99
        L94:
            java.lang.String r0 = "Error getting Firebase installation id ."
            android.util.Log.w(r2, r0, r10)
        L99:
            vc.w r10 = new vc.w
            r10.<init>(r5, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.q.a(ic.d, xd.c):java.lang.Object");
    }

    @Override // qd.a
    public Object get() {
        switch (this.f13677v) {
            case 1:
                return e1.f13610a;
            default:
                return f1.f13616a;
        }
    }
}
