package b8;

import android.graphics.Path;
import android.graphics.PathMeasure;
import androidx.media3.decoder.DecoderInputBuffer;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1940a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f1940a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0L;
            case 1:
                return new Random();
            case 2:
                return new PathMeasure();
            case 3:
                return new Path();
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new Path();
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new float[4];
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(ve.b.f13501e);
                return simpleDateFormat;
        }
    }
}
