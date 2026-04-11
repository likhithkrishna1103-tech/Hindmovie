package y6;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f14956c = {"_data"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f14957d = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f14959b;

    public /* synthetic */ a(ContentResolver contentResolver, int i) {
        this.f14958a = i;
        this.f14959b = contentResolver;
    }

    @Override // y6.b
    public final Cursor a(Uri uri) {
        switch (this.f14958a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f14959b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f14956c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f14959b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f14957d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
