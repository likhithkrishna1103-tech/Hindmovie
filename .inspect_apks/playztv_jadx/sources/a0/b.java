package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f0a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5g;

    public b(b bVar, Object obj) {
        bVar.getClass();
        this.f1b = bVar.f1b;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), s.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i = 0;
        boolean z2 = false;
        Object objValueOf = null;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == s.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == s.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z2 = true;
            } else if (index == s.CustomAttribute_customBoolean) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else if (index == s.CustomAttribute_customColorValue) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i = 3;
            } else if (index == s.CustomAttribute_customColorDrawableValue) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i = 4;
            } else {
                if (index == s.CustomAttribute_customPixelDimension) {
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == s.CustomAttribute_customDimension) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == s.CustomAttribute_customFloatValue) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    i = 2;
                } else if (index == s.CustomAttribute_customIntegerValue) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    i = 1;
                } else if (index == s.CustomAttribute_customStringValue) {
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                    i = 5;
                } else if (index == s.CustomAttribute_customReference) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                    i = 8;
                }
                i = 7;
            }
        }
        if (string != null && objValueOf != null) {
            b bVar = new b();
            bVar.f1b = i;
            bVar.f0a = z2;
            bVar.b(objValueOf);
            map.put(string, bVar);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (v.e.c(this.f1b)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f2c = ((Integer) obj).intValue();
                break;
            case 1:
                this.f3d = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f5g = ((Integer) obj).intValue();
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                this.f4e = (String) obj;
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                this.f = ((Boolean) obj).booleanValue();
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f3d = ((Float) obj).floatValue();
                break;
        }
    }
}
