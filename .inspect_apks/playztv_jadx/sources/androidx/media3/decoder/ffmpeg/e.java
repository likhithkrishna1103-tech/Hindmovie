package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f1563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1566d;

    public e(int i, String[] strArr) {
        this.f1566d = i;
        this.f1563a = strArr;
    }

    public final synchronized boolean a() {
        if (this.f1564b) {
            return this.f1565c;
        }
        this.f1564b = true;
        try {
            for (String str : this.f1563a) {
                switch (this.f1566d) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        System.loadLibrary(str);
                        break;
                    default:
                        System.loadLibrary(str);
                        break;
                }
            }
            this.f1565c = true;
        } catch (UnsatisfiedLinkError unused) {
            s1.b.p("LibraryLoader", "Failed to load " + Arrays.toString(this.f1563a));
        }
        return this.f1565c;
    }
}
