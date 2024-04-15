def isIsomorphic(s, t):
    map_st = {}
    for _s, _t in zip(s, t):

        if _s not in map_st:
            map_st[_s] = _t
        else:
            if map_st[_s] != _t:  # In case same char mapped to different char
                return False

    print(map_st)
    print(map_st.keys())
    print(map_st.values())

    return len(map_st.keys()) == len(set(map_st.values()))  # All mapped chars len should be equal to len of values;
    # We use set to prevent mapping two different chars to same char


# "badc"
# "baba"
if __name__ == "__main__":
    print(isIsomorphic("badc", "baba"))
