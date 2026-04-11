package s8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import j9.e0;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;
import p8.d;
import p8.i;
import p8.j;
import p8.k;
import p8.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f11928e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f11930h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11932k;

    public c(Context context, b bVar) {
        AttributeSet attributeSetAsAttributeSet;
        int styleAttribute;
        Locale locale;
        int next;
        int i = a.I;
        int i10 = a.H;
        this.f11925b = new b();
        bVar = bVar == null ? new b() : bVar;
        int i11 = bVar.f11918u;
        if (i11 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i11);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e10) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i11));
                notFoundException.initCause(e10);
                throw notFoundException;
            }
        } else {
            attributeSetAsAttributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = e0.d(context, attributeSetAsAttributeSet, l.Badge, i, styleAttribute == 0 ? i10 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f11926c = typedArrayD.getDimensionPixelSize(l.Badge_badgeRadius, -1);
        this.i = context.getResources().getDimensionPixelSize(d.mtrl_badge_horizontal_edge_offset);
        this.f11931j = context.getResources().getDimensionPixelSize(d.mtrl_badge_text_horizontal_edge_offset);
        this.f11927d = typedArrayD.getDimensionPixelSize(l.Badge_badgeWithTextRadius, -1);
        this.f11928e = typedArrayD.getDimension(l.Badge_badgeWidth, resources.getDimension(d.m3_badge_size));
        this.f11929g = typedArrayD.getDimension(l.Badge_badgeWithTextWidth, resources.getDimension(d.m3_badge_with_text_size));
        this.f = typedArrayD.getDimension(l.Badge_badgeHeight, resources.getDimension(d.m3_badge_size));
        this.f11930h = typedArrayD.getDimension(l.Badge_badgeWithTextHeight, resources.getDimension(d.m3_badge_with_text_size));
        this.f11932k = typedArrayD.getInt(l.Badge_offsetAlignmentMode, 1);
        b bVar2 = this.f11925b;
        int i12 = bVar.C;
        bVar2.C = i12 == -2 ? 255 : i12;
        int i13 = bVar.E;
        if (i13 != -2) {
            bVar2.E = i13;
        } else if (typedArrayD.hasValue(l.Badge_number)) {
            this.f11925b.E = typedArrayD.getInt(l.Badge_number, 0);
        } else {
            this.f11925b.E = -1;
        }
        String str = bVar.D;
        if (str != null) {
            this.f11925b.D = str;
        } else if (typedArrayD.hasValue(l.Badge_badgeText)) {
            this.f11925b.D = typedArrayD.getString(l.Badge_badgeText);
        }
        b bVar3 = this.f11925b;
        bVar3.I = bVar.I;
        CharSequence charSequence = bVar.J;
        bVar3.J = charSequence == null ? context.getString(j.mtrl_badge_numberless_content_description) : charSequence;
        b bVar4 = this.f11925b;
        int i14 = bVar.K;
        bVar4.K = i14 == 0 ? i.mtrl_badge_content_description : i14;
        int i15 = bVar.L;
        bVar4.L = i15 == 0 ? j.mtrl_exceed_max_badge_number_content_description : i15;
        Boolean bool = bVar.N;
        bVar4.N = Boolean.valueOf(bool == null || bool.booleanValue());
        b bVar5 = this.f11925b;
        int i16 = bVar.F;
        bVar5.F = i16 == -2 ? typedArrayD.getInt(l.Badge_maxCharacterCount, -2) : i16;
        b bVar6 = this.f11925b;
        int i17 = bVar.G;
        bVar6.G = i17 == -2 ? typedArrayD.getInt(l.Badge_maxNumber, -2) : i17;
        b bVar7 = this.f11925b;
        Integer num = bVar.f11922y;
        bVar7.f11922y = Integer.valueOf(num == null ? typedArrayD.getResourceId(l.Badge_badgeShapeAppearance, k.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        b bVar8 = this.f11925b;
        Integer num2 = bVar.f11923z;
        bVar8.f11923z = Integer.valueOf(num2 == null ? typedArrayD.getResourceId(l.Badge_badgeShapeAppearanceOverlay, 0) : num2.intValue());
        b bVar9 = this.f11925b;
        Integer num3 = bVar.A;
        bVar9.A = Integer.valueOf(num3 == null ? typedArrayD.getResourceId(l.Badge_badgeWithTextShapeAppearance, k.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        b bVar10 = this.f11925b;
        Integer num4 = bVar.B;
        bVar10.B = Integer.valueOf(num4 == null ? typedArrayD.getResourceId(l.Badge_badgeWithTextShapeAppearanceOverlay, 0) : num4.intValue());
        b bVar11 = this.f11925b;
        Integer num5 = bVar.f11919v;
        bVar11.f11919v = Integer.valueOf(num5 == null ? a.a.i(context, typedArrayD, l.Badge_backgroundColor).getDefaultColor() : num5.intValue());
        b bVar12 = this.f11925b;
        Integer num6 = bVar.f11921x;
        bVar12.f11921x = Integer.valueOf(num6 == null ? typedArrayD.getResourceId(l.Badge_badgeTextAppearance, k.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = bVar.f11920w;
        if (num7 != null) {
            this.f11925b.f11920w = num7;
        } else if (typedArrayD.hasValue(l.Badge_badgeTextColor)) {
            this.f11925b.f11920w = Integer.valueOf(a.a.i(context, typedArrayD, l.Badge_badgeTextColor).getDefaultColor());
        } else {
            int iIntValue = this.f11925b.f11921x.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, l.TextAppearance);
            typedArrayObtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f);
            ColorStateList colorStateListI = a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColor);
            a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColorHint);
            a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColorLink);
            typedArrayObtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
            typedArrayObtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
            int i18 = l.TextAppearance_fontFamily;
            i18 = typedArrayObtainStyledAttributes.hasValue(i18) ? i18 : l.TextAppearance_android_fontFamily;
            typedArrayObtainStyledAttributes.getResourceId(i18, 0);
            typedArrayObtainStyledAttributes.getString(i18);
            typedArrayObtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
            a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_shadowColor);
            typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, l.MaterialTextAppearance);
            typedArrayObtainStyledAttributes2.hasValue(l.MaterialTextAppearance_android_letterSpacing);
            typedArrayObtainStyledAttributes2.getFloat(l.MaterialTextAppearance_android_letterSpacing, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f11925b.f11920w = Integer.valueOf(colorStateListI.getDefaultColor());
        }
        b bVar13 = this.f11925b;
        Integer num8 = bVar.M;
        bVar13.M = Integer.valueOf(num8 == null ? typedArrayD.getInt(l.Badge_badgeGravity, 8388661) : num8.intValue());
        b bVar14 = this.f11925b;
        Integer num9 = bVar.O;
        bVar14.O = Integer.valueOf(num9 == null ? typedArrayD.getDimensionPixelSize(l.Badge_badgeWidePadding, resources.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        b bVar15 = this.f11925b;
        Integer num10 = bVar.P;
        bVar15.P = Integer.valueOf(num10 == null ? typedArrayD.getDimensionPixelSize(l.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(d.m3_badge_with_text_vertical_padding)) : num10.intValue());
        b bVar16 = this.f11925b;
        Integer num11 = bVar.Q;
        bVar16.Q = Integer.valueOf(num11 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_horizontalOffset, 0) : num11.intValue());
        b bVar17 = this.f11925b;
        Integer num12 = bVar.R;
        bVar17.R = Integer.valueOf(num12 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_verticalOffset, 0) : num12.intValue());
        b bVar18 = this.f11925b;
        Integer num13 = bVar.S;
        bVar18.S = Integer.valueOf(num13 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_horizontalOffsetWithText, bVar18.Q.intValue()) : num13.intValue());
        b bVar19 = this.f11925b;
        Integer num14 = bVar.T;
        bVar19.T = Integer.valueOf(num14 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_verticalOffsetWithText, bVar19.R.intValue()) : num14.intValue());
        b bVar20 = this.f11925b;
        Integer num15 = bVar.W;
        bVar20.W = Integer.valueOf(num15 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_largeFontVerticalOffsetAdjustment, 0) : num15.intValue());
        b bVar21 = this.f11925b;
        Integer num16 = bVar.U;
        bVar21.U = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        b bVar22 = this.f11925b;
        Integer num17 = bVar.V;
        bVar22.V = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        b bVar23 = this.f11925b;
        Boolean bool2 = bVar.X;
        bVar23.X = Boolean.valueOf(bool2 == null ? typedArrayD.getBoolean(l.Badge_autoAdjustToWithinGrandparentBounds, false) : bool2.booleanValue());
        typedArrayD.recycle();
        Locale locale2 = bVar.H;
        if (locale2 == null) {
            b bVar24 = this.f11925b;
            if (Build.VERSION.SDK_INT >= 24) {
                Locale.Category unused = Locale.Category.FORMAT;
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            bVar24.H = locale;
        } else {
            this.f11925b.H = locale2;
        }
        this.f11924a = bVar;
    }
}
