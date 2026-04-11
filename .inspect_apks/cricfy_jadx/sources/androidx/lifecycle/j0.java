package androidx.lifecycle;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends ge.j implements fe.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f1166w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f1167x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(int i, Object obj) {
        super(0);
        this.f1166w = i;
        this.f1167x = obj;
    }

    @Override // fe.a
    public final Object b() {
        switch (this.f1166w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return i0.e((u0) this.f1167x);
            case 1:
                Object obj = d1.l0.f3267e;
                File file = (File) this.f1167x;
                synchronized (obj) {
                    d1.l0.f3266d.remove(file.getAbsolutePath());
                }
                return rd.l.f11003a;
            case 2:
                ((pe.h0) this.f1167x).b();
                return rd.l.f11003a;
            default:
                File file2 = (File) ((f1.a) this.f1167x).b();
                String name = file2.getName();
                ge.i.d(name, "getName(...)");
                if (ne.h.r0('.', name, "").equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    ge.i.d(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }
}
