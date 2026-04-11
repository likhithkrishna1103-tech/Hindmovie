package g7;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements x6.j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x6.g f5184d = new x6.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new d0());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x6.g f5185e = new x6.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new j());
    public static final f9.c0 f = new f9.c0(12);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f5186g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f5187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.b f5188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f9.c0 f5189c = f;

    public g0(a7.b bVar, f0 f0Var) {
        this.f5188b = bVar;
        this.f5187a = f0Var;
    }

    @Override // x6.j
    public final boolean a(Object obj, x6.h hVar) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) throws Exception {
        long jLongValue = ((Long) hVar.c(f5184d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) hVar.c(f5185e);
        if (num == null) {
            num = 2;
        }
        n nVar = (n) hVar.c(n.f5200g);
        if (nVar == null) {
            nVar = n.f;
        }
        n nVar2 = nVar;
        this.f5189c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f5187a.p(mediaMetadataRetriever, obj);
            try {
                Bitmap bitmapC = c(obj, mediaMetadataRetriever, jLongValue, num.intValue(), i, i10, nVar2);
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                } else if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                } else if (mediaMetadataRetriever instanceof ExecutorService) {
                    a9.b.y((ExecutorService) mediaMetadataRetriever);
                } else {
                    mediaMetadataRetriever.release();
                }
                return d.b(this.f5188b, bitmapC);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof ExecutorService) {
                    a9.b.y((ExecutorService) mediaMetadataRetriever);
                    throw th2;
                }
                mediaMetadataRetriever.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #2 {all -> 0x006b, blocks: (B:23:0x005f, B:25:0x0065), top: B:91:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(java.lang.Object r14, android.media.MediaMetadataRetriever r15, long r16, int r18, int r19, int r20, g7.n r21) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.g0.c(java.lang.Object, android.media.MediaMetadataRetriever, long, int, int, int, g7.n):android.graphics.Bitmap");
    }
}
