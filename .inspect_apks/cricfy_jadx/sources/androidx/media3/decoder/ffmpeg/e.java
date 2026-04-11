package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f1261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1264d;

    public e(int i, String[] strArr) {
        this.f1264d = i;
        this.f1261a = strArr;
    }

    public final synchronized boolean a() {
        if (this.f1262b) {
            return this.f1263c;
        }
        this.f1262b = true;
        try {
            for (String str : this.f1261a) {
                switch (this.f1264d) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        System.loadLibrary(str);
                        break;
                    default:
                        System.loadLibrary(str);
                        break;
                }
            }
            this.f1263c = true;
        } catch (UnsatisfiedLinkError unused) {
            y1.b.p("LibraryLoader", "Failed to load " + Arrays.toString(this.f1261a));
        }
        return this.f1263c;
    }
}
