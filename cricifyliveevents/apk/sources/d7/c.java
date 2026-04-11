package d7;

import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements x6.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3458v;

    public /* synthetic */ c(int i) {
        this.f3458v = i;
    }

    public static ByteArrayInputStream a(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    public Class b() {
        switch (this.f3458v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ByteBuffer.class;
            case 1:
                return InputStream.class;
            case 2:
            case 3:
            default:
                return InputStream.class;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // x6.b
    public boolean m(Object obj, File file, x6.h hVar) throws Throwable {
        try {
            s7.b.d((ByteBuffer) obj, file);
            return true;
        } catch (IOException e9) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e9);
            return false;
        }
    }
}
