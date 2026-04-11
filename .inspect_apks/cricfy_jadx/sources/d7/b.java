package d7;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3455c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f3453a = i;
        this.f3455c = obj;
        this.f3454b = obj2;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        com.bumptech.glide.load.data.j jVar;
        s sVarA;
        Uri uri;
        switch (this.f3453a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri2 = (Uri) obj;
                String strSubstring = uri2.toString().substring(22);
                r7.b bVar = new r7.b(uri2);
                AssetManager assetManager = (AssetManager) this.f3455c;
                switch (((a) this.f3454b).f3446a) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        jVar = new com.bumptech.glide.load.data.j(assetManager, strSubstring, 0);
                        break;
                    default:
                        jVar = new com.bumptech.glide.load.data.j(assetManager, strSubstring, 1);
                        break;
                }
                return new s(bVar, jVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) hVar.c(i7.c.f6348b);
                return new s(new r7.b(num), new h(theme, theme != null ? theme.getResources() : ((Context) this.f3455c).getResources(), (g) this.f3454b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.f3455c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                x6.e eVar = null;
                for (int i11 = 0; i11 < size; i11++) {
                    t tVar = (t) arrayList.get(i11);
                    if (tVar.b(obj) && (sVarA = tVar.a(obj, i, i10, hVar)) != null) {
                        eVar = sVarA.f3507a;
                        arrayList2.add(sVarA.f3509c);
                    }
                }
                if (arrayList2.isEmpty() || eVar == null) {
                    return null;
                }
                return new s(eVar, new y(arrayList2, (s0.c) this.f3454b));
            case 3:
                Integer num2 = (Integer) obj;
                try {
                    uri = Uri.parse("android.resource://" + ((Resources) this.f3454b).getResourcePackageName(num2.intValue()) + '/' + num2);
                    break;
                } catch (Resources.NotFoundException e9) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e9);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((t) this.f3455c).a(uri, i, i10, hVar);
            default:
                Uri uri3 = (Uri) obj;
                t tVar2 = (t) this.f3454b;
                List<String> pathSegments = uri3.getPathSegments();
                s sVarA2 = null;
                if (pathSegments.size() == 1) {
                    try {
                        int i12 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i12 != 0) {
                            sVarA2 = tVar2.a(Integer.valueOf(i12), i, i10, hVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return sVarA2;
                    } catch (NumberFormatException e10) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return sVarA2;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e10);
                        return sVarA2;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.f3455c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return tVar2.a(Integer.valueOf(identifier), i, i10, hVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        switch (this.f3453a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                ArrayList arrayList = (ArrayList) this.f3455c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (((t) obj2).b(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.f3455c).getPackageName().equals(uri2.getAuthority());
        }
    }

    public String toString() {
        switch (this.f3453a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f3455c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public b(Resources resources, t tVar) {
        this.f3453a = 3;
        this.f3454b = resources;
        this.f3455c = tVar;
    }

    public b(Context context, g gVar) {
        this.f3453a = 1;
        this.f3455c = context.getApplicationContext();
        this.f3454b = gVar;
    }

    public b(Context context, t tVar) {
        this.f3453a = 4;
        this.f3455c = context.getApplicationContext();
        this.f3454b = tVar;
    }
}
