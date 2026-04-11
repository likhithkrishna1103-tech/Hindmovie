package i6;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Resources.Theme f6395u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Resources f6396v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f6397w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f6398x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f6399y;

    public f(Resources.Theme theme, Resources resources, e eVar, int i) {
        this.f6395u = theme;
        this.f6396v = resources;
        this.f6397w = eVar;
        this.f6398x = i;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f6397w.f6391a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        Object obj = this.f6399y;
        if (obj != null) {
            try {
                switch (this.f6397w.f6391a) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 1:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, com.bumptech.glide.load.data.d dVar) {
        Object objOpenRawResourceFd;
        try {
            e eVar = this.f6397w;
            Resources.Theme theme = this.f6395u;
            Resources resources = this.f6396v;
            int i = this.f6398x;
            switch (eVar.f6391a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    objOpenRawResourceFd = resources.openRawResourceFd(i);
                    break;
                case 1:
                    Context context = eVar.f6392b;
                    objOpenRawResourceFd = t1.n(context, context, i, theme);
                    break;
                default:
                    objOpenRawResourceFd = resources.openRawResource(i);
                    break;
            }
            this.f6399y = objOpenRawResourceFd;
            dVar.r(objOpenRawResourceFd);
        } catch (Resources.NotFoundException e10) {
            dVar.l(e10);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}
