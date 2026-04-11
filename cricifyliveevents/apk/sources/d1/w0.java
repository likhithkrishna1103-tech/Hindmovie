package d1;

import android.os.ParcelFileDescriptor;
import androidx.datastore.core.NativeSharedCounter;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends ge.j implements fe.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3312w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ z0 f3313x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(z0 z0Var, int i) {
        super(0);
        this.f3312w = i;
        this.f3313x = z0Var;
    }

    @Override // fe.a
    public final Object b() throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpen;
        switch (this.f3312w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                System.loadLibrary("datastore_shared_counter");
                z0 z0Var = this.f3313x;
                File file = new File(z0Var.f3325b.getAbsolutePath() + z0Var.f3328e);
                z0.f(z0Var, file);
                try {
                    parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 939524096);
                    try {
                        int fd2 = parcelFileDescriptorOpen.getFd();
                        NativeSharedCounter nativeSharedCounter = g1.f3232b;
                        if (nativeSharedCounter.nativeTruncateFile(fd2) != 0) {
                            throw new IOException("Failed to truncate counter file");
                        }
                        long jNativeCreateSharedCounter = nativeSharedCounter.nativeCreateSharedCounter(fd2);
                        if (jNativeCreateSharedCounter < 0) {
                            throw new IOException("Failed to mmap counter file");
                        }
                        g1 g1Var = new g1(jNativeCreateSharedCounter);
                        parcelFileDescriptorOpen.close();
                        return g1Var;
                    } catch (Throwable th) {
                        th = th;
                        if (parcelFileDescriptorOpen != null) {
                            parcelFileDescriptorOpen.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelFileDescriptorOpen = null;
                }
                break;
            default:
                z0 z0Var2 = this.f3313x;
                File file2 = new File(z0Var2.f3325b.getAbsolutePath() + z0Var2.f3327d);
                z0.f(z0Var2, file2);
                return file2;
        }
    }
}
