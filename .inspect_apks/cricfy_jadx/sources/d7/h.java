package d7;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Resources.Theme f3480v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Resources f3481w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f3482x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3483y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3484z;

    public h(Resources.Theme theme, Resources resources, g gVar, int i) {
        this.f3480v = theme;
        this.f3481w = resources;
        this.f3482x = gVar;
        this.f3483y = i;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3482x.f3476a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f3484z;
        if (obj != null) {
            try {
                switch (this.f3482x.f3476a) {
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

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) {
        Object objOpenRawResourceFd;
        try {
            g gVar = this.f3482x;
            Resources.Theme theme = this.f3480v;
            Resources resources = this.f3481w;
            int i = this.f3483y;
            switch (gVar.f3476a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    objOpenRawResourceFd = resources.openRawResourceFd(i);
                    break;
                case 1:
                    Context context = gVar.f3477b;
                    objOpenRawResourceFd = sd.i.s(context, context, i, theme);
                    break;
                default:
                    objOpenRawResourceFd = resources.openRawResource(i);
                    break;
            }
            this.f3484z = objOpenRawResourceFd;
            cVar.d(objOpenRawResourceFd);
        } catch (Resources.NotFoundException e9) {
            cVar.c(e9);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
