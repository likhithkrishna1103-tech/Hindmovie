package n9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import da.d0;
import java.io.IOException;
import java.util.Locale;
import k9.d;
import k9.i;
import k9.j;
import k9.k;
import k9.l;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f8914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8915e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f8916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f8917h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8920l;

    public c(Context context) {
        AttributeSet attributeSetAsAttributeSet;
        int styleAttribute;
        Locale locale;
        int next;
        int i = a.J;
        int i10 = a.I;
        this.f8912b = new b();
        b bVar = new b();
        int i11 = bVar.f8906v;
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
            } catch (IOException | XmlPullParserException e9) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i11));
                notFoundException.initCause(e9);
                throw notFoundException;
            }
        } else {
            attributeSetAsAttributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = d0.d(context, attributeSetAsAttributeSet, l.Badge, i, styleAttribute == 0 ? i10 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f8913c = typedArrayD.getDimensionPixelSize(l.Badge_badgeRadius, -1);
        this.i = context.getResources().getDimensionPixelSize(d.mtrl_badge_horizontal_edge_offset);
        this.f8918j = context.getResources().getDimensionPixelSize(d.mtrl_badge_text_horizontal_edge_offset);
        this.f8914d = typedArrayD.getDimensionPixelSize(l.Badge_badgeWithTextRadius, -1);
        this.f8915e = typedArrayD.getDimension(l.Badge_badgeWidth, resources.getDimension(d.m3_badge_size));
        this.f8916g = typedArrayD.getDimension(l.Badge_badgeWithTextWidth, resources.getDimension(d.m3_badge_with_text_size));
        this.f = typedArrayD.getDimension(l.Badge_badgeHeight, resources.getDimension(d.m3_badge_size));
        this.f8917h = typedArrayD.getDimension(l.Badge_badgeWithTextHeight, resources.getDimension(d.m3_badge_with_text_size));
        this.f8919k = typedArrayD.getInt(l.Badge_offsetAlignmentMode, 1);
        this.f8920l = typedArrayD.getInt(l.Badge_badgeFixedEdge, 0);
        b bVar2 = this.f8912b;
        int i12 = bVar.D;
        bVar2.D = i12 == -2 ? 255 : i12;
        int i13 = bVar.F;
        if (i13 != -2) {
            bVar2.F = i13;
        } else if (typedArrayD.hasValue(l.Badge_number)) {
            this.f8912b.F = typedArrayD.getInt(l.Badge_number, 0);
        } else {
            this.f8912b.F = -1;
        }
        String str = bVar.E;
        if (str != null) {
            this.f8912b.E = str;
        } else if (typedArrayD.hasValue(l.Badge_badgeText)) {
            this.f8912b.E = typedArrayD.getString(l.Badge_badgeText);
        }
        b bVar3 = this.f8912b;
        bVar3.J = bVar.J;
        CharSequence charSequence = bVar.K;
        bVar3.K = charSequence == null ? context.getString(j.mtrl_badge_numberless_content_description) : charSequence;
        b bVar4 = this.f8912b;
        int i14 = bVar.L;
        bVar4.L = i14 == 0 ? i.mtrl_badge_content_description : i14;
        int i15 = bVar.M;
        bVar4.M = i15 == 0 ? j.mtrl_exceed_max_badge_number_content_description : i15;
        Boolean bool = bVar.O;
        bVar4.O = Boolean.valueOf(bool == null || bool.booleanValue());
        b bVar5 = this.f8912b;
        int i16 = bVar.G;
        bVar5.G = i16 == -2 ? typedArrayD.getInt(l.Badge_maxCharacterCount, -2) : i16;
        b bVar6 = this.f8912b;
        int i17 = bVar.H;
        bVar6.H = i17 == -2 ? typedArrayD.getInt(l.Badge_maxNumber, -2) : i17;
        b bVar7 = this.f8912b;
        Integer num = bVar.f8910z;
        bVar7.f8910z = Integer.valueOf(num == null ? typedArrayD.getResourceId(l.Badge_badgeShapeAppearance, k.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        b bVar8 = this.f8912b;
        Integer num2 = bVar.A;
        bVar8.A = Integer.valueOf(num2 == null ? typedArrayD.getResourceId(l.Badge_badgeShapeAppearanceOverlay, 0) : num2.intValue());
        b bVar9 = this.f8912b;
        Integer num3 = bVar.B;
        bVar9.B = Integer.valueOf(num3 == null ? typedArrayD.getResourceId(l.Badge_badgeWithTextShapeAppearance, k.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        b bVar10 = this.f8912b;
        Integer num4 = bVar.C;
        bVar10.C = Integer.valueOf(num4 == null ? typedArrayD.getResourceId(l.Badge_badgeWithTextShapeAppearanceOverlay, 0) : num4.intValue());
        b bVar11 = this.f8912b;
        Integer num5 = bVar.f8907w;
        bVar11.f8907w = Integer.valueOf(num5 == null ? com.bumptech.glide.c.i(context, typedArrayD, l.Badge_backgroundColor).getDefaultColor() : num5.intValue());
        b bVar12 = this.f8912b;
        Integer num6 = bVar.f8909y;
        bVar12.f8909y = Integer.valueOf(num6 == null ? typedArrayD.getResourceId(l.Badge_badgeTextAppearance, k.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = bVar.f8908x;
        if (num7 != null) {
            this.f8912b.f8908x = num7;
        } else if (typedArrayD.hasValue(l.Badge_badgeTextColor)) {
            this.f8912b.f8908x = Integer.valueOf(com.bumptech.glide.c.i(context, typedArrayD, l.Badge_badgeTextColor).getDefaultColor());
        } else {
            int iIntValue = this.f8912b.f8909y.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, g.j.TextAppearance);
            typedArrayObtainStyledAttributes.getDimension(g.j.TextAppearance_android_textSize, 0.0f);
            ColorStateList colorStateListI = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, g.j.TextAppearance_android_textColor);
            com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, g.j.TextAppearance_android_textColorHint);
            com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, g.j.TextAppearance_android_textColorLink);
            typedArrayObtainStyledAttributes.getInt(g.j.TextAppearance_android_textStyle, 0);
            typedArrayObtainStyledAttributes.getInt(g.j.TextAppearance_android_typeface, 1);
            int i18 = g.j.TextAppearance_fontFamily;
            i18 = typedArrayObtainStyledAttributes.hasValue(i18) ? i18 : g.j.TextAppearance_android_fontFamily;
            typedArrayObtainStyledAttributes.getResourceId(i18, 0);
            typedArrayObtainStyledAttributes.getString(i18);
            typedArrayObtainStyledAttributes.getBoolean(g.j.TextAppearance_textAllCaps, false);
            com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, g.j.TextAppearance_android_shadowColor);
            typedArrayObtainStyledAttributes.getFloat(g.j.TextAppearance_android_shadowDx, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(g.j.TextAppearance_android_shadowDy, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(g.j.TextAppearance_android_shadowRadius, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, l.MaterialTextAppearance);
            typedArrayObtainStyledAttributes2.hasValue(l.MaterialTextAppearance_android_letterSpacing);
            typedArrayObtainStyledAttributes2.getFloat(l.MaterialTextAppearance_android_letterSpacing, 0.0f);
            if (Build.VERSION.SDK_INT >= 26) {
                int i19 = l.MaterialTextAppearance_fontVariationSettings;
                typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(i19) ? i19 : l.MaterialTextAppearance_android_fontVariationSettings);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f8912b.f8908x = Integer.valueOf(colorStateListI.getDefaultColor());
        }
        b bVar13 = this.f8912b;
        Integer num8 = bVar.N;
        bVar13.N = Integer.valueOf(num8 == null ? typedArrayD.getInt(l.Badge_badgeGravity, 8388661) : num8.intValue());
        b bVar14 = this.f8912b;
        Integer num9 = bVar.P;
        bVar14.P = Integer.valueOf(num9 == null ? typedArrayD.getDimensionPixelSize(l.Badge_badgeWidePadding, resources.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        b bVar15 = this.f8912b;
        Integer num10 = bVar.Q;
        bVar15.Q = Integer.valueOf(num10 == null ? typedArrayD.getDimensionPixelSize(l.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(d.m3_badge_with_text_vertical_padding)) : num10.intValue());
        b bVar16 = this.f8912b;
        Integer num11 = bVar.R;
        bVar16.R = Integer.valueOf(num11 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_horizontalOffset, 0) : num11.intValue());
        b bVar17 = this.f8912b;
        Integer num12 = bVar.S;
        bVar17.S = Integer.valueOf(num12 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_verticalOffset, 0) : num12.intValue());
        b bVar18 = this.f8912b;
        Integer num13 = bVar.T;
        bVar18.T = Integer.valueOf(num13 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_horizontalOffsetWithText, bVar18.R.intValue()) : num13.intValue());
        b bVar19 = this.f8912b;
        Integer num14 = bVar.U;
        bVar19.U = Integer.valueOf(num14 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_verticalOffsetWithText, bVar19.S.intValue()) : num14.intValue());
        b bVar20 = this.f8912b;
        Integer num15 = bVar.X;
        bVar20.X = Integer.valueOf(num15 == null ? typedArrayD.getDimensionPixelOffset(l.Badge_largeFontVerticalOffsetAdjustment, 0) : num15.intValue());
        b bVar21 = this.f8912b;
        Integer num16 = bVar.V;
        bVar21.V = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        b bVar22 = this.f8912b;
        Integer num17 = bVar.W;
        bVar22.W = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        b bVar23 = this.f8912b;
        Boolean bool2 = bVar.Y;
        bVar23.Y = Boolean.valueOf(bool2 == null ? typedArrayD.getBoolean(l.Badge_autoAdjustToWithinGrandparentBounds, false) : bool2.booleanValue());
        typedArrayD.recycle();
        Locale locale2 = bVar.I;
        if (locale2 == null) {
            b bVar24 = this.f8912b;
            if (Build.VERSION.SDK_INT >= 24) {
                Locale.Category unused = Locale.Category.FORMAT;
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            bVar24.I = locale;
        } else {
            this.f8912b.I = locale2;
        }
        this.f8911a = bVar;
    }
}
