package d6;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4077c = {"_data"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f4078d = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f4080b;

    public /* synthetic */ a(ContentResolver contentResolver, int i) {
        this.f4079a = i;
        this.f4080b = contentResolver;
    }

    @Override // d6.c
    public final Cursor a(Uri uri) {
        switch (this.f4079a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f4080b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4077c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f4080b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4078d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
