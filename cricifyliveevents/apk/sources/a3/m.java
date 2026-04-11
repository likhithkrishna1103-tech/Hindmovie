package a3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.abt.component.AbtRegistrar;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import v1.t0;
import v1.u0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements hb.e, e8.g, ta.f, y1.m, y1.n, s7.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f219v;

    public /* synthetic */ m(int i) {
        this.f219v = i;
    }

    @Override // y1.m
    public void a(Object obj) {
        switch (this.f219v) {
            case 9:
                ((u0) obj).u(new g2.n(2, new a9.l("Player release timed out."), 1003));
                break;
            case 10:
            case 12:
            case 27:
            default:
                ((h2.k) obj).getClass();
                break;
            case 11:
                ((u0) obj).s();
                break;
            case 13:
                ((h2.k) obj).getClass();
                break;
            case 14:
                ((h2.k) obj).getClass();
                break;
            case 15:
                ((h2.k) obj).getClass();
                break;
            case 16:
                ((h2.k) obj).getClass();
                break;
            case 17:
                ((h2.k) obj).getClass();
                break;
            case 18:
                ((h2.k) obj).getClass();
                break;
            case 19:
                ((h2.k) obj).getClass();
                break;
            case 20:
                ((h2.k) obj).getClass();
                break;
            case 21:
                ((h2.k) obj).getClass();
                break;
            case 22:
                ((h2.k) obj).getClass();
                break;
            case 23:
                ((h2.k) obj).getClass();
                break;
            case 24:
                ((h2.k) obj).getClass();
                break;
            case 25:
                ((h2.k) obj).getClass();
                break;
            case 26:
                ((h2.k) obj).getClass();
                break;
            case 28:
                ((h2.k) obj).getClass();
                break;
        }
    }

    @Override // e8.g, ta.f
    public Object apply(Object obj) {
        switch (this.f219v) {
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (cursorRawQuery.moveToNext()) {
                        l7.a aVarA = x7.i.a();
                        aVarA.J(cursorRawQuery.getString(1));
                        aVarA.f7868y = h8.a.b(cursorRawQuery.getInt(2));
                        String string = cursorRawQuery.getString(3);
                        aVarA.f7867x = string == null ? null : Base64.decode(string, 0);
                        arrayList.add(aVarA.m());
                        break;
                    }
                    return arrayList;
                } finally {
                    cursorRawQuery.close();
                }
            default:
                return new h2.f((y1.v) obj);
        }
    }

    @Override // y1.n
    public void b(Object obj, v1.n nVar) {
        switch (this.f219v) {
            case 10:
                ((u0) obj).h(new t0(nVar));
                break;
            default:
                break;
        }
    }

    public Constructor c() {
        switch (this.f219v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(p.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(p.class).getConstructor(null);
        }
    }

    @Override // hb.e
    public Object e(dd.c cVar) {
        return AbtRegistrar.lambda$getComponents$0(cVar);
    }

    @Override // s7.g
    public Object get() {
        if (Build.VERSION.SDK_INT == 34) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            z = bitmapCopy == null;
            if (Log.isLoggable("GainmapWorkaroundCalc", 2)) {
                Log.v("GainmapWorkaroundCalc", "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
        }
        return Boolean.valueOf(z);
    }
}
