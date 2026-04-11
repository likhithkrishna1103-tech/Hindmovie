package d1;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends ge.j implements fe.l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final k0 f3258w = new k0(1);

    @Override // fe.l
    public final Object a(Object obj) {
        File file = (File) obj;
        ge.i.e(file, "it");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        ge.i.d(absolutePath, "file.canonicalFile.absolutePath");
        return new k1(absolutePath);
    }
}
