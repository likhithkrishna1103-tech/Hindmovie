package x;

import aa.c0;
import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static String a(StringBuilder sb2, int i, String str) {
        sb2.append(i);
        sb2.append(str);
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(y4.c cVar) throws Exception {
        if (cVar instanceof AutoCloseable) {
            cVar.close();
            return;
        }
        if (cVar instanceof ExecutorService) {
            c0.x((ExecutorService) cVar);
            return;
        }
        if (cVar instanceof TypedArray) {
            ((TypedArray) cVar).recycle();
            return;
        }
        if (cVar instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) cVar).release();
            return;
        }
        if (cVar instanceof MediaDrm) {
            ((MediaDrm) cVar).release();
        } else if (cVar instanceof DrmManagerClient) {
            ((DrmManagerClient) cVar).release();
        } else {
            if (!(cVar instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) cVar).release();
        }
    }

    public static /* synthetic */ String c(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return "RIGHT";
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return "BOTTOM";
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return "BASELINE";
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }
}
