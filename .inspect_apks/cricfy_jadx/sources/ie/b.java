package ie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import androidx.media3.decoder.DecoderInputBuffer;
import g1.h;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import lf.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6449a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f6449a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new Random();
            case 1:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(f.f7964a);
                return simpleDateFormat;
            case 2:
                return new PathMeasure();
            case 3:
                return new Path();
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new Path();
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new float[4];
            default:
                return 0L;
        }
    }
}
